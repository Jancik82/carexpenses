package pl.edu.wszib.ce.carexpenses.service;

public interface ServiceEntriesService {

    Float sumCostService();

    Float minCostService();

    String minDescriptionService();

    Float maxCostService();

    String maxDescriptionService();

    Float avgCostService();
}
