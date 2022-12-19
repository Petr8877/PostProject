package by.itacademy.postproject.service.factory;


import by.itacademy.postproject.service.StatisticService;
import by.itacademy.postproject.service.api.IStatisticService;

public class StatisticServiceSingleton {
    private volatile static StatisticService instance;

    private StatisticServiceSingleton() {
    }

    public static IStatisticService getInstance(){
        if(instance == null){
            synchronized (StatisticService.class){
                if(instance == null){
                    instance = new StatisticService(MessageServiceSingleton.getInstance(),
                            RegistrationServiceSingleton.getInstance());
                }
            }
        }
        return instance;
    }
}
