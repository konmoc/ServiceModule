package com.company.service.thread;


import com.company.service.service.StartAppService;

public class StartAppThread implements Runnable {
    @Override
    public void run() {
        StartAppService startAppService = new StartAppService();
        startAppService.startApp();
    }
}
