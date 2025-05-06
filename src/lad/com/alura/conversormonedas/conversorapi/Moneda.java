package lad.com.alura.conversormonedas.conversorapi;

public class Moneda {
    private String code;

    public Moneda(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("El código de la moneda no puede estar vacío.");
        }
        this.code = code.toUpperCase();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("El código de la moneda no puede estar vacío.");
        }
        this.code = code.toUpperCase();
    }
}
