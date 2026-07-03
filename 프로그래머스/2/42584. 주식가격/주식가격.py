import math


def solution(prices):
    """
    기존 코드. 단조 스택 사용
    루프를 순회하며 들어오는 입력값(price_val)이 기존의 수와의 대소 여부만 판단하면 되기에, 스택 자료구조 사용
    answer을 prices의 size만큼 미리 math.inf로 초기화하여, idx를 통해 접근 가능하게 만들어, prices와 idx 동기화

    * 해당 문제에서 스택 자료구조를 사용해야 하는 이유
    1. 과거 데이터의 계산 타이밍이 일정하지 않음
    일반적인 문제에서는 데이터가 들어오는 즉시 계산을 수행하던가, 앞에서부터 차례대로 계산이 끝나지만,
    해당 문제는 사건이 발생하는(가격 하락) 특정 시점까지 과거 데이터의 계산을 미뤄두어야 함

    2. 단조성이 깨지는 지점을 찾아야 함
    특정 사건(가격 하락)에만 반응을 하기에, 단조성이 깨지는 타이밍을 포착하여, 과거 데이터를 사용해야하는 경우, 단조스택을 사용해야함
    특정 사건 전까지는 데이터를 저장해야하고, 그 자료구조로 스택이 적합

    +) 다중 루프의 시간 복잡도 계산
    초기에는 다중 루프 구성이라 O(N^2)으로 생각하였기에, 최악의 경우 연산량이 10^10으로 생각하여, 해당 풀이가 아닌 다른 풀이를 고민했지만,
    해당 풀이에서, 매 바깥 루프마다, 정적인 횟수(n)을 반복하는 것이 아니기 떄문에, 문제가 없다는 것을 꺠달았음
    결국 내부에서 pop을 수행하는데, 이 pop을 모든 바깥 루프 통틀어서 수행할 수 있는 횟수는 n번이기 떄문에, 최종적인 시간 복잡도는 O(N)이 된다.

    +) 기존에는 monotonic_stack을 [idx][price]꼴의 2차원으로 구성 => prices[monotonic[k](idx)]로 접근하는 것보다,
    monotonic_stack[k][1]로 접근하는 것이, 별도로 prices를 참조하지 않기에 성능적으로 더 우수할 줄 알았음
    but 파이썬의 각 자료형마다 객체 생성 비용이 무겁고, 인덱스 기반 접근은 O(1)이기에, 수정 버전 monotonic[k]=idx로 수정

    :param prices: idx를 시점으로, value를 가격으로 갖고 있는 prices 리스트
    :return: prices의 시점별 가격이 몇초간 떨어지지 않는지에 대한 정보를 담은 리스트
    """
    prices_size = len(prices)
    answer = [math.inf] * prices_size
    monotonic_stack = []
    for price_idx, price_val in enumerate(prices):

        # while monotonic_stack and price_val < monotonic_stack[-1][1]:
        while monotonic_stack and price_val < prices[monotonic_stack[-1]]:
            popped_idx = monotonic_stack.pop()
            # popped_idx = monotonic_stack.pop()[0]
            answer[popped_idx] = price_idx - popped_idx

        # monotonic_stack.append([price_idx, price_val])
        monotonic_stack.append(price_idx)

    for remained_idx in monotonic_stack:
        answer[remained_idx] = prices_size - (1 + remained_idx)
    return answer