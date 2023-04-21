class Niveles {   
    protected int noPlanetas;
    protected int noAsteroides;
    protected int noHoyosNegros;
    protected int noBalas;
    protected int noCapsulas;

    protected int nivel;
    protected boolean PASS;
    protected boolean sePuedeDisparar;

    public Niveles(){       //Constructor de la clase

    }
    
    public int determinaSiguienteNivel(){
        return nivel;
    }
    public boolean ganaNivel(){
        return PASS;
    }
    public int calculaRestanteBalas(){
        return noBalas;
    }
    public int calculaRestanteCapsulas(){
        return noCapsulas;
    }
    public boolean posibDisparar(){
        return sePuedeDisparar;
    }
}


/////////////////////////////////////////////////////////
//                   CLASE DEL NIVEL 1                 //
/////////////////////////////////////////////////////////
class Niv1 extends Niveles{
    protected int planetasSinVidaDestruidos;
    protected boolean planetaConVidaDestruido;
    public Niv1(){          //Constructor de la clase Niv1
        super();
    }
}

/////////////////////////////////////////////////////////
//                  CLASE DEL NIVEL 2                  //
/////////////////////////////////////////////////////////
class Niv2 extends Niveles{
    protected int noAsteroidesDestruidos;
    protected boolean asteroideChocado;
    public Niv2(){          //Constructor de la clase Niv2
        super();
    }
}

//////////////////////////////////////////////////////////
//                  CLASE DEL NIVEL 3                   //
//////////////////////////////////////////////////////////
class Niv3 extends Niveles{
    protected int noHoyosNegrosDestruidos;
    protected boolean absorbido;            //Determina si es que se ha "chocado" con un hoyo negro
    public Niv3(){                          //Constructor de la clase Niv3
        super();
    }
}