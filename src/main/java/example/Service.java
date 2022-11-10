package example;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface for a service which will be accessible remotely
 */
public interface Service extends Remote {
    Integer pollElem() throws RemoteException;

    void addElem(int str) throws RemoteException;

    void countNumberOfWords(int fib) throws RemoteException;

}