package example;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Implementation of the remote service.
 */
public class ServiceImpl extends UnicastRemoteObject implements Service {
    private final BlockingQueue<Integer> queue;
    private int count = 0;

    public ServiceImpl() throws RemoteException {
        super();
        this.queue = new LinkedBlockingQueue<>();
    }

    @Override
    public Integer pollElem() throws RemoteException {
        return this.queue.poll();
    }

    @Override
    public void addElem(int n) throws RemoteException {
        this.queue.add(n);
        System.out.println("Added: " + n);
    }

    @Override
    public void countNumberOfWords(int wordCounter) throws RemoteException {
        synchronized (this) {
            count += wordCounter;
            System.out.println("Received result: " + wordCounter + ", count: " + count);
        }
    }
}