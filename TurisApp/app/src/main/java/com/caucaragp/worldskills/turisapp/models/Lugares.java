package com.caucaragp.worldskills.turisapp.models;

public class Lugares {
    //Declaración de variables
    /*Nota: Las variables no estan en la convencion de nombrado de código debido a que la libreria
        Gson necesita que las variables json sean del mismo nombre que la clase a convertir
     */
    private int id;
    private String Nombre;
    private String descripcioncorta;
    private String ubicacion;
    private String descripcion;
    private double latitud;
    private double longitud;
    private String tipolugar;
    private String urlimagen;

    public Lugares() {
    }

    //Método para obtener el atributo id del objeto
    public int getId() {
        return id;
    }

    //Método para ingresar el atributo id del objeto
    public void setId(int id) {
        this.id = id;
    }

    //Método para obtener el atributo nombre del objeto
    public String getNombre() {
        return Nombre;
    }

    //Método para ingresar el atributo nombre del objeto

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    //Método para obtener el atributo descripcionCorta del objeto
    public String getDescripcioncorta() {
        return descripcioncorta;
    }

    //Método para ingresar el atributo descripcionCorta del objeto
    public void setDescripcioncorta(String descripcioncorta) {
        this.descripcioncorta = descripcioncorta;
    }

    //Método para obtener el atributo ubicacion del objeto
    public String getUbicacion() {
        return ubicacion;
    }

    //Método para ingresar el atributo ubicacion del objeto
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    //Método para obtener el atributo descripcion del objeto
    public String getDescripcion() {
        return descripcion;
    }

    //Método para ingresar el atributo descripcion del objeto
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    //Método para obtener el atributo latitud del objeto
    public double getLatitud() {
        return latitud;
    }

    //Método para ingresar el atributo latitud del objeto
    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    //Método para obtener el atributo longitud del objeto
    public double getLongitud() {
        return longitud;
    }

    //Método para ingresar el atributo longitud del objeto
    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    //Método para obtener el atributo tipoLugar del objeto
    public String getTipolugar() {
        return tipolugar;
    }

    //Método para ingresar el atributo tipoLugar del objeto
    public void setTipolugar(String tipolugar) {
        this.tipolugar = tipolugar;
    }

    //Método para obtener el atributo urlImagen del objeto
    public String getUrlimagen() {
        return urlimagen;
    }

    //Método para ingresar el atributo urlImagen del objeto
    public void setUrlimagen(String urlimagen) {
        this.urlimagen = urlimagen;
    }
}
