/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package agenda;

import java.util.ArrayList;

/**
 *
 * @author nandocode
 */
public class Agenda {

    //private Cliente personas[];
    private final int TOTAL_LISTA = 10;
    ArrayList<Cliente> personas;
    private int indice;

    public Agenda() {
        //personas = new Cliente[TOTAL_LISTA];
        personas = new ArrayList<Cliente>(TOTAL_LISTA);
        indice = -1;
    }

    public boolean addLista(Cliente obj) {
        // agrega objetos al ArrayList
        boolean respuesta = false;

        if (indice < TOTAL_LISTA - 1) {
            indice++;
            // personas[indice] = obj;
            personas.add(obj);
            respuesta = true;

        }
        return respuesta;
    }

    public boolean eliminarPersona(int id) {
        boolean respuesta = false;
        if (!vacia()) {

            if (existeFolio(id)) {
                int posicion = buscarPersona(id);
                // Acomoda eliminando al primer cliente 
                for (int i = posicion; i <= indice; i++) {
                    if (!(i == indice)) {
                        personas.set(i, personas.get(i + 1));

                        //personas[i] = personas[i + 1];
                    } else {
                        personas.remove(indice);
                    }
                }
                respuesta = true;
                indice--;

            } else {
                System.out.println("No existe filio");
            }

        } else {
            System.out.println("array vacio");
        }

        return respuesta;

    }

    public boolean existeFolio(int Busq_folio) {
        boolean bandera = false;

        for (int i = 0; i <= indice; i++) {

            if (Busq_folio == personas.get(i).getFolio()) {
                bandera = true;
                break;
            }
        }
        return bandera;

    }

    public int buscarPersona(int folio) {
        int respuesta = -1;
        for (int i = 0; i <= indice; i++) {
            if (personas.get(i).getFolio() == folio) {
                respuesta = i;
                break;
            }
        }
        return respuesta;

    }

    public boolean vacia() {
        boolean bandera;
        if (indice == -1) {
            bandera = true;
        } else {
            bandera = false;
        }
        return bandera;

    }

    public int getIndice() {
        return indice;
    }

    public Cliente itemAgenda(int i) {
        return personas.get(i);
    }

    public int personasLength() {

       // System.out.println(personas.size());
        return personas.size();

    }

}
