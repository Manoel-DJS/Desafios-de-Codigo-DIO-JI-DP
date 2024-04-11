package Desafio;

import java.util.Scanner;

interface Employee {
    double calculateSalary();
}

interface ContractType {
    double getSalary();
    // TODO: Método para obter o salário conforme o tipo de contrato
    
}

class CLTEmployee implements Employee {
    private final ContractType contractType;
    public CLTEmployee(ContractType contractType) {
        this.contractType = contractType;
    }
    @Override
    public double calculateSalary() {
        return contractType.getSalary();
    }
}

// TUDO: Defina a implementação para colaboradores PJ
class PJEmployee implements Employee {
    private final ContractType contractType;
    public PJEmployee(ContractType contractType) {
        this.contractType = contractType;
    }
    @Override
    public double calculateSalary() {
        return contractType.getSalary();
    }
}

class CLT implements ContractType {
    private final double baseSalary;
    private final double commissions;
    public CLT(double baseSalary, double commissions) {
        this.baseSalary = baseSalary;
        this.commissions = commissions;
    }
    @Override
    public double getSalary() {
        return baseSalary + commissions;
    }
}

// TODO: Defina a implementação de contrato PJ
class PJ implements ContractType {
    private final double hours;
    private final double valuehour;
    public PJ(double hours, double valuehour){
        this.hours = hours;
        this.valuehour = valuehour;
    }
    @Override
    public double getSalary() {
        return hours * valuehour;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String contractType = scanner.nextLine();
        if (contractType.equalsIgnoreCase("CLT")) {
            String[] input = scanner.nextLine().split(",");
            double baseSalary = Double.parseDouble(input[0]);
            double commissions = Double.parseDouble(input[1]);
            ContractType cltContract = new CLT(baseSalary, commissions);
            Employee cltEmployee = new CLTEmployee(cltContract);
            System.out.println("CLT: " + cltEmployee.calculateSalary());
        } else if(contractType.equalsIgnoreCase("PJ")){
            String[] input = scanner.nextLine().split(",");
            double hours = Double.parseDouble(input[0]);
            double valuehour = Double.parseDouble(input[1]);
            ContractType pjContract = new PJ(hours, valuehour);
            Employee pjEmployee = new PJEmployee(pjContract);
            System.out.println("PJ: " + pjEmployee.calculateSalary());
        }
        // TODO: Complemente a lógica para a leitura e impressão referentes ao regime PJ
        scanner.close();
    }
}