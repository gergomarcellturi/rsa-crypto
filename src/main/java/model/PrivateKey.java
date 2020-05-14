package model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PrivateKey {
    private long d;

    public PrivateKey( long d) {
        this.d = d;
    }
}
