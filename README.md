# 구현할 기능 목록

- *는 필수 요구사항

## 1. 참가자 이름 입력
- [x숫] 5글자까지만 가능하다 *
  - [x] <예외> 5글자 초과일 경우 *
  - [x] <예외> 이름이 중복될 경우
- [ ] 쉼표(,)를 기준으로 구분한다 *

## 2. 사다리 최대 높이 입력
- [x] <예외> 숫자가 아닐 경우
- [x] <예외> 0 이하의 값이 들어올 경우

## 3. 사다리 생성
- [x] 가로 라인은 겹칠 수 없다
  ```
  |-----|-----| // 불가
  |-----|     | // 가능
  ```

## 4. 사다리 출력
- [ ] 사람 이름도 함께 출력 한다
  - [ ] 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.