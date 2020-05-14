package model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PublicKey {
    private long n;
    private long e;

    public PublicKey(long n, long e) {
        this.n = n;
        this.e = e;
    }
}
