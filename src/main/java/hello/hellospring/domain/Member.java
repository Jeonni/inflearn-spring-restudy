package hello.hellospring.domain;

public class Member {
    private Long ig;
    private String name;

    public Long getId() {
        return ig;
    }

    public void setId(Long id) {
        this.ig = ig;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
