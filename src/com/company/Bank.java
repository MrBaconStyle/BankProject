package com.company;

import java.util.ArrayList;

public class Bank {

    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches = new ArrayList<Branch>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public boolean addBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
        }
        return false;
    }

    public boolean addCustomer(String branchName, String customerName, double amount) {
        Branch currentBranch = findBranch(branchName);
        if (currentBranch != null) {
            return currentBranch.addCustomer(customerName, amount);
        }
        return false;
    }

    public boolean addBranchTransaction(String branchName, String customerName, double amount) {
        Branch currentBranch = findBranch(branchName);
        if (currentBranch != null) {
            return currentBranch.addCustomerTransaction(customerName, amount);
        }
        return false;
    }

    private Branch findBranch(String branchName) {
        for (int i=0; i<branches.size(); i++) {
            Branch currentBranch = branches.get(i);
            if (currentBranch.getName().equals(branchName)){
                return currentBranch;
            }
        }
        return null;
    }

    public boolean printCustomers(String branchName, boolean showTransaction) {
        Branch currentBranch = findBranch(branchName);
        if (currentBranch != null) {
            System.out.println("Customer details for branch: " + currentBranch.getName());
            ArrayList<Customer> currentCustomers = currentBranch.getCustomers();
            for (int i=0; i<currentCustomers.size(); i++) {
                System.out.println("Customer: ");
                System.out.println((i+1) + ". " + currentCustomers.get(i).getName());
            }
        }
    }
}
