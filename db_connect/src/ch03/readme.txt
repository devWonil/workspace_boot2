preparedStatement 사용법

Statement와 preparedStatement의 차이점은 캐시 사용 유무입니다
따라서 반복적으로 쿼리를 수행한다면 Statement에 비해 성능이 훨씬 좋다
그리고 보안적인 측면에서도 Statement보다 preparedStatement가 안정성이 높다