package pl.coderslab.entity;

enum UserDao {
    ADD_USER(1, "Dodaj użytkownika"),
    EDIT_USER(2, "Edytuj użytkownika"),
    GET_FROM_ID(3, "Wyszukaj użytkownika po ID"),
    DELETE_FROM_ID(4, "Wpisz ID użytkonika, którego chcesz usunąć"),
    PRINT_USERS(5, "Wyświetl użytkowników"),
    EXIT(6, "wYJŚCIE Z PROGRAMU");

    int number;
    String destripcion;

    UserDao(int number, String destripcion) {
        this.number = number;
        this.destripcion = destripcion;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDestripcion() {
        return destripcion;
    }

    public void setDestripcion(String destripcion) {
        this.destripcion = destripcion;
    }
    public String toString (){
        return number + " " + destripcion;
    }
}

