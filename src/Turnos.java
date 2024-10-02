public class Turnos implements Comparable<Turnos> {
    private int edad;
    private char sexo;
    private boolean embarazada;
    private boolean clienteGrande;
    private int secuencia;
    private String identificador;

    public Turnos(int edad, char sexo, boolean embarazada, boolean clienteGrande, int secuencia, String identificador) {
        this.edad = edad;
        this.sexo = sexo;
        this.embarazada = embarazada;
        this.clienteGrande = clienteGrande;
        this.secuencia = secuencia;
        this.identificador = identificador;
    }

    public int getEdad() {
        return edad;
    }

    public char getSexo() {
        return sexo;
    }

    public boolean isEmbarazada() {
        return embarazada;
    }

    public boolean isClienteGrande() {
        return clienteGrande;
    }

    public int getSecuencia() {
        return secuencia;
    }

    public String getIdentificador() {
        return identificador;
    }

    @Override
    public int compareTo(Turnos t) {
        if (this.edad >= 60 && t.edad < 60) {
            return -1;
        } else if (this.edad < 60 && t.edad >= 60) {
            return 1;
        } else if (this.edad == t.edad) {
            if (this.sexo != t.sexo) {
                return this.sexo == 'F' ? -1 : 1;
            }
            return Integer.compare(this.secuencia, t.secuencia);
        }
        return Integer.compare(t.edad, this.edad); // Descending order for age
    }

    @Override
    public String toString() {
        return "Turnos{" +
                "edad=" + edad +
                ", sexo=" + sexo +
                ", embarazada=" + embarazada +
                ", clienteGrande=" + clienteGrande +
                ", secuencia=" + secuencia +
                ", identificador='" + identificador + '\'' +
                '}';
    }
}