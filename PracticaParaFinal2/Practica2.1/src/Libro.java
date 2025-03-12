public class Libro {
    String titulo;
    String autor;
    String genero;
    int anioPublicacion;
    int cantEjemplares;
    int identificador;
    Libro hijIzq;
    Libro hijDer;

    public Libro(String titulo, String autor, String genero, int anioPublicacion, int cantEjemplares, int identificador){
        this.titulo=titulo;
        this.autor=autor;
        this.genero=genero;
        this.anioPublicacion=anioPublicacion;
        this.cantEjemplares=cantEjemplares;
        this.identificador=identificador;
        this.hijIzq=null;
        this.hijDer=null;
    }

    public void setTitulo(String titulo){
        this.titulo=titulo;
    }
    public String getTitulo(){
        return titulo;
    }
    public void setAutor(String autor){
        this.autor=autor;
    }
    public String getAutor(){
        return autor;
    }
    public void setGenero(String genero){
        this.genero=genero;
    }
    public String getGenero(){
        return genero;
    }
    public void setAnioPublicacion(int anioPublicacion){
        this.anioPublicacion=anioPublicacion;
    }
    public int getAnioPublicacion(){
        return anioPublicacion;
    }
    public void setCantEjemplares(int cantEjemplares){
        this.cantEjemplares=cantEjemplares;
    }
    public int getCantEjemplares(){
        return cantEjemplares;
    }
    public void setIdentificador(int identificador){
        this.identificador=identificador;
    }
    public int getIdentificador(){
        return identificador;
    }
    public void setHijIzq(Libro hijIzq){
        this.hijIzq=hijIzq;
    }
    public Libro getHijIzq(){
        return hijIzq;
    }
    public void setHijDer(Libro hijDer){
        this.hijDer=hijDer;
    }
    public Libro getHijDer(){
        return hijDer;
    }




}
