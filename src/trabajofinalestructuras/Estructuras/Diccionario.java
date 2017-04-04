package trabajofinalestructuras.Estructuras;

import trabajofinalestructuras.Utiles.Ciudad;

public class Diccionario {

    private Nodo raiz;

    public Diccionario() {
        raiz = null;
    }

    public void vaciar() {
        raiz = null;
    }

    public boolean esVacio() {
        return (raiz == null);
    }

    public boolean insertar(String clave, Ciudad ciudad) {
        boolean res;
        if (raiz == null) {
            raiz = new Nodo(clave, ciudad);
            res = true;
        } else {
            res = insertarAux(clave, ciudad, raiz, null);
        }
        return res;
    }

    private boolean insertarAux(String clave, Ciudad ciudad, Nodo nodo, Nodo padre) {

        boolean res;
        if (nodo.getClave().equals(clave)) {
            res = false;
        } else {
            if (clave.compareTo(nodo.getClave()) < 0) {
                if (nodo.getHijoIzquierdo() == null) {
                    nodo.setHijoIzquierdo(new Nodo(clave, ciudad));
                    nodo.setAltura(altura(nodo));
                    res = true;
                } else {
                    res = insertarAux(clave, ciudad, nodo.getHijoIzquierdo(), nodo);
                    nodo.setAltura(altura(nodo));
                }
            } else {
                if (nodo.getHijoDerecho() == null) {
                    nodo.setHijoDerecho(new Nodo(clave, ciudad));
                    nodo.setAltura(altura(nodo));
                    res = true;
                } else {
                    res = insertarAux(clave, ciudad, nodo.getHijoDerecho(), nodo);
                    nodo.setAltura(altura(nodo));
                }
            }
            balancear(nodo, padre);
        }
        return res;
    }

    public boolean eliminar(String clave) {
        boolean res;
        
        if (raiz == null) {
            res = false;
        } else {
            res = eliminarAux(clave, raiz, null);
            if (raiz != null) {
                raiz.setAltura(altura(raiz));
            }
        }
        return res;
    }

    private boolean eliminarAux(String clave, Nodo nodo, Nodo padre) {
        boolean res;
        int cantHijos;
        String valorAux;
        Ciudad ciudadAux;
        Nodo aux;
        if (nodo != null) {
            if (clave.compareTo(nodo.getClave()) < 0) {
                res = eliminarAux(clave, nodo.getHijoIzquierdo(), nodo);
                nodo.setAltura(altura(nodo));
            } else if (clave.compareTo(nodo.getClave()) > 0) {
                res = eliminarAux(clave, nodo.getHijoDerecho(), nodo);
                nodo.setAltura(altura(nodo));
            } else {
                cantHijos = cantHijos(nodo);
                switch (cantHijos) {
                    case 0:
                        if (padre == null) {
                            raiz = null;
                        } else {
                            if (nodo.getClave().compareTo(padre.getClave()) < 0) {
                                padre.setHijoIzquierdo(null);
                            } else {
                                padre.setHijoDerecho(null);
                            }
                            padre.setAltura(altura(padre));
                        }   break;
                    case 1:
                        if (padre == null) {
                            raiz = raiz.getHijoIzquierdo();
                            raiz.setAltura(altura(raiz));
                        } else {
                            if (nodo.getClave().compareTo(padre.getClave()) < 0) {
                                padre.setHijoIzquierdo(nodo.getHijoIzquierdo());
                            } else {
                                padre.setHijoDerecho(nodo.getHijoIzquierdo());
                            }
                            padre.setAltura(altura(padre));
                        }   break;
                    case 2:
                        if (padre == null) {
                            raiz = raiz.getHijoDerecho();
                            raiz.setAltura(altura(raiz));
                        } else {
                            if (nodo.getClave().compareTo(padre.getClave()) < 0) {
                                padre.setHijoIzquierdo(nodo.getHijoDerecho());
                            } else {
                                padre.setHijoDerecho(nodo.getHijoDerecho());
                            }
                            padre.setAltura(altura(padre));
                        }   break;
                    default:
                        aux = nodo.getHijoIzquierdo();
                        while (aux.getHijoDerecho() != null) {
                            aux = aux.getHijoDerecho();
                        }   valorAux = aux.getClave();
                        ciudadAux = aux.getCiudad();
                        eliminarAux(valorAux, raiz, null);
                        nodo.setClave(valorAux);
                        nodo.setCiudad(ciudadAux);
                        nodo.setAltura(altura(nodo));
                        if (padre != null) {
                            padre.setAltura(altura(padre));
                        }   break;
                }
                res = true;
            }
            balancear(nodo, padre);
        } else {
            res = false;
        }
        return res;
    }

    public Ciudad obtenerCiudad(String clave) {
        Ciudad res = null;
        
        if (raiz != null) {
            res = obtenerCiudadAux(clave, raiz);
        }
        return res;
    }

    private Ciudad obtenerCiudadAux(String clave, Nodo nodo) {
        Ciudad res;
        if (nodo.getClave().compareTo(clave) == 0) {
            res = nodo.getCiudad();
        } else {
            if (clave.compareTo(nodo.getClave()) < 0 && nodo.getHijoIzquierdo() != null) {
                res = obtenerCiudadAux(clave, nodo.getHijoIzquierdo());
            } else if (clave.compareTo(nodo.getClave()) > 0 && nodo.getHijoDerecho() != null) {
                res = obtenerCiudadAux(clave, nodo.getHijoDerecho());
            } else {
                res = null;
            }
        }
        return res;
    }

    public boolean existeCiudad(String nombre) {
        boolean res;
        if (raiz == null) {
            res = false;
        } else {
            res = existeCiudadAux(nombre, raiz);
        }
        return res;
    }

    private boolean existeCiudadAux(String nombre, Nodo nodo) {
        boolean res;
        if (nodo.getClave().equals(nombre)) {
            res = true;
        } else {
            if (nombre.compareTo(nodo.getClave()) < 0 && nodo.getHijoIzquierdo() != null) {
                res = existeCiudadAux(nombre, nodo.getHijoIzquierdo());
            } else if (nombre.compareTo(nodo.getClave()) > 0 && nodo.getHijoDerecho() != null) {
                res = existeCiudadAux(nombre, nodo.getHijoDerecho());
            } else {
                res = false;
            }
        }
        return res;
    }

    public int alturaDiccionario() {
        return raiz.getAltura();
    }

    private int altura(Nodo nodo) {
        int res;
        Nodo hijoI;
        Nodo hijoD;
        if (nodo == null) {
            res = -1;
        } else {
            hijoI = nodo.getHijoIzquierdo();
            hijoD = nodo.getHijoDerecho();
            if (hijoI == null) {
                if (hijoD == null) {
                    res = 0;
                } else {
                    res = hijoD.getAltura() + 1;
                }
            } else {
                if (hijoD == null) {
                    res = hijoI.getAltura() + 1;
                } else {
                    if (hijoI.getAltura() > hijoD.getAltura()) {
                        res = hijoI.getAltura() + 1;
                    } else {
                        res = hijoD.getAltura() + 1;
                    }
                }
            }
        }
        return res;
    }

    private int cantHijos(Nodo nodo) {
        int res;
        Nodo hI = nodo.getHijoIzquierdo(), hD = nodo.getHijoDerecho();
        if (hI == null) {
            if (hD == null) {
                res = 0;
            } else {
                res = 2;
            }
        } else {
            if (hD == null) {
                res = 1;
            } else {
                res = 3;
            }
        }
        return res;
    }

    private void balancear(Nodo nodo, Nodo padre) {
        int balance;
        Nodo aux;
        balance = balance(nodo);
        if (balance < -1) {
            aux = nodo.getHijoDerecho();
            balance = balance(aux);
            if (balance == 1) {
                nodo.setHijoDerecho(rotacionDerecha(nodo.getHijoDerecho()));
            }
            if (padre == null) {
                raiz = rotacionIzquierda(nodo);
            } else {
                if (nodo.getClave().compareTo(padre.getClave()) < 0) {
                    padre.setHijoIzquierdo(rotacionIzquierda(nodo));
                } else {
                    padre.setHijoDerecho(rotacionIzquierda(nodo));
                }
                padre.setAltura(altura(padre));
            }
        }
        if (balance > 1) {
            aux = nodo.getHijoIzquierdo();
            balance = balance(aux);
            if (balance == -1) {
                nodo.setHijoIzquierdo(rotacionIzquierda(nodo.getHijoIzquierdo()));
            }
            if (padre == null) {
                raiz = rotacionDerecha(nodo);
            } else {
                if (nodo.getClave().compareTo(padre.getClave()) < 0) {
                    padre.setHijoIzquierdo(rotacionDerecha(nodo));
                } else {
                    padre.setHijoDerecho(rotacionDerecha(nodo));
                }
                padre.setAltura(altura(padre));
            }
        }
    }

    private Nodo rotacionDerecha(Nodo nodo) {
        Nodo aux = nodo.getHijoIzquierdo();
        Nodo aux2 = aux.getHijoDerecho();
        aux.setHijoDerecho(nodo);
        nodo.setHijoIzquierdo(aux2);
        nodo.setAltura(altura(nodo));
        aux.setAltura(altura(aux));
        return aux;
    }

    private Nodo rotacionIzquierda(Nodo nodo) {
        Nodo aux = nodo.getHijoDerecho();
        Nodo aux2 = aux.getHijoIzquierdo();
        aux.setHijoIzquierdo(nodo);
        nodo.setHijoDerecho(aux2);
        nodo.setAltura(altura(nodo));
        aux.setAltura(altura(aux));
        return aux;
    }

    private int balance(Nodo nodo) {
        int res;
        if (nodo.getHijoIzquierdo() != null) {
            if (nodo.getHijoDerecho() != null) {
                res = nodo.getHijoIzquierdo().getAltura() - nodo.getHijoDerecho().getAltura();
            } else {
                res = nodo.getHijoIzquierdo().getAltura() + 1;
            }
        } else {
            if (nodo.getHijoDerecho() != null) {
                res = -1 - nodo.getHijoDerecho().getAltura();
            } else {
                res = 0;
            }
        }
        return res;
    }

    public ListaString listarClavesRango(String inicio, String fin) {
        ListaString lista = new ListaString();
        if (raiz != null) {
            listarClavesRangoAux(lista, raiz, inicio, fin);
        }
        return lista;
    }

    private void listarClavesRangoAux(ListaString lista, Nodo nodo, String inicio, String fin) {
        if (inicio.compareTo(nodo.getClave().toUpperCase()) < 0) {
            if (nodo.getHijoIzquierdo() != null) {
                listarClavesRangoAux(lista, nodo.getHijoIzquierdo(), inicio, fin);
            }
        }        
        if (nodo.getClave().toUpperCase().compareTo(inicio) >= 0 && nodo.getClave().toUpperCase().compareTo(fin) <= 0) {
            lista.insertar(nodo.getClave(), lista.longitud() + 1);
        }

        if (fin.compareTo(nodo.getClave().toUpperCase()) > 0) {
            if (nodo.getHijoDerecho() != null) {
                listarClavesRangoAux(lista, nodo.getHijoDerecho(), inicio, fin);
            }
        }
    }
    
    public void mostrarArbol() {
        if (raiz == null) {
            System.out.println("Arbol Vacio");
        } else {
            mostrarArbolAux(raiz);
        }
    }

    private void mostrarArbolAux(Nodo n) {
        int i = 0;
        if (n.getHijoIzquierdo() == null && n.getHijoDerecho() == null) {
        } else {
            if (n.getHijoIzquierdo() != null) {
                while (i <= n.getHijoIzquierdo().getClave().length()) {
                    System.out.print(" ");
                    i++;
                }
            }
            System.out.println(n.getClave());
            i = 1;
            if (n.getHijoIzquierdo() != null) {
                while (i <= n.getHijoIzquierdo().getClave().length()) {
                    System.out.print(" ");
                    i++;
                }
                System.out.print("/");
            }
            i = 1;
            while (i <= n.getClave().length()) {
                System.out.print(" ");
                i++;
            }
            if (n.getHijoDerecho() != null) {
                System.out.println("\\");
            } else {
                System.out.println("");
            }
            i = 1;
            if (n.getHijoIzquierdo() != null) {
                System.out.print(n.getHijoIzquierdo().getClave() + " ");
            }
            while (i <= n.getClave().length()) {
                System.out.print(" ");
                i++;
            }
            System.out.print(" ");
            if (n.getHijoDerecho() != null) {
                System.out.print(n.getHijoDerecho().getClave());
            }
            System.out.println("\n");
            if (n.getHijoIzquierdo() != null) {

                mostrarArbolAux(n.getHijoIzquierdo());
            }
            if (n.getHijoDerecho() != null) {

                mostrarArbolAux(n.getHijoDerecho());
            }
        }
    }

    public ListaString listarInOrden() {
        ListaString l = new ListaString();
        listarInOrdenAux(this.raiz, l);
        return l;
    }

    private void listarInOrdenAux(Nodo n, ListaString l) {
        if (n != null) {
            listarInOrdenAux(n.getHijoIzquierdo(), l);
            l.insertar(n.getClave(), l.longitud() + 1);
            listarInOrdenAux(n.getHijoDerecho(), l);
        }
    }
}
