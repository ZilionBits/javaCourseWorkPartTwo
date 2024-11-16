package lt.stud.techin;

import lt.itakademija.exam.*;
import lt.itakademija.exam.Package;

import java.util.ArrayList;
import java.util.List;

public class Castle extends Warehouse implements ClientPredicate {

    private final List<Client> clients = new ArrayList<>();

    public Castle(IdGenerator clientIdGenerator, IdGenerator packageIdGenerator, int totalSpace) {
        super(clientIdGenerator, packageIdGenerator, totalSpace);
    }

    @Override
    public int getTotalSpace() {
        return super.totalSpace;
    }

    @Override
    public int getAvailableSpace() {
        int reservedSpace = clients.stream()
                .mapToInt(Client::getReservedSpace)
                .sum();

        return super.totalSpace - reservedSpace;
    }

    @Override
    public int getTotalAvailableSpace() {
        int reservedPackageSpace = clients.stream()
                .flatMap(c -> c.getPackages().stream())
                .mapToInt(Package::getSpace)
                .sum();
        return totalSpace - reservedPackageSpace;
    }

    @Override
    public int getReservedSpace() {
        return clients.stream().mapToInt(Client::getReservedSpace).sum();
    }

    @Override
    public Client registerClient(String s, int i) {

        if(i <= 0 ){
            throw new IllegalArgumentException();
        }
        if(i > getTotalAvailableSpace()){
            throw new InsufficientSpaceException("Not enough space.");
        }

        Client client = new Client(super.clientIdGenerator.generateId(), s, i);
        clients.add(client);
        return client;
    }

    @Override
    public Package createPackage(String s, int i) {
        if(i <= 0 ){
            throw new IllegalArgumentException();
        }

        return new Package(super.getPackageIdGenerator().generateId(), s, i);
    }

    @Override
    public void storePackage(Client client, Package aPackage) {

        if(client.getAvailableSpace() < aPackage.getSpace()){
            throw new InsufficientSpaceException("Not enough space.");
        }

        client.addPackage(aPackage);
    }

    @Override
    public Client getClientById(int i) {
        return clients.stream().filter(c -> c.getId()==i).findFirst().orElse(null);
    }

    @Override
    public boolean hasClientById(int i) {
        return clients.stream().anyMatch(c -> c.getId() == i);
    }

    @Override
    public List<Client> findClientsBy(ClientPredicate clientPredicate) {
        return clients.stream().filter(clientPredicate::test).toList();
    }

    @Override
    public boolean test(Client client) {
        return clients.stream().anyMatch(c -> c.getId() == client.getId());
    }
}
