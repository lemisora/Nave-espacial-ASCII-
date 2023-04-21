class Niveles {   
    protected int noPlanetas;
    protected int noAsteroides;
    protected int noHoyosNegros;
    protected int noBalas;
    protected int noCapsulas;

    protected int nivel;
    protected boolean PASS;
    protected boolean sePuedeDisparar;
    
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
}

/////////////////////////////////////////////////////////
//                  CLASE DEL NIVEL 2                  //
/////////////////////////////////////////////////////////
class Niv2 extends Niveles{
}

//////////////////////////////////////////////////////////
//                  CLASE DEL NIVEL 3                   //
//////////////////////////////////////////////////////////
class Niv3 extends Niveles{
}