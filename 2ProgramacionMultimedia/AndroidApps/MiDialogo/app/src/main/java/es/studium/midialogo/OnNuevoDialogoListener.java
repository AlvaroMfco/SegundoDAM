package es.studium.midialogo;

public interface OnNuevoDialogoListener {
    public void mostrarDlgNombre();
    public void mostrarDlgSexo();
    public void mostrarDlgRaza();
    public void mostrarDlgClase();
    public void setDatosPj(String dato, int pos);
    public void enviarDatos();
    public void ocultarComenzar();
    public void mostrarComenzar();
}
