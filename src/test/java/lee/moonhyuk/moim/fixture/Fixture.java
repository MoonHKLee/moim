package lee.moonhyuk.moim.fixture;

public enum Fixture {
    SIGN_UP("""
            {
              "name": "name",
              "birthDate": "1994-09-25",
              "sex": "MALE",
              "memberId": "moonhyuk.lee",
              "password": "P@ssw0rd",
              "email": "moonhyuk.lee@gmail.com",
              "organization": "youth-room"
            }
            """);
    String content;

    Fixture(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
