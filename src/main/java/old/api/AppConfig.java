///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package old.api;
//
//import java.util.Set;
//import jakarta.ws.rs.core.Application;
//
///**
// *
// * @author fist2000
// */
//@jakarta.ws.rs.ApplicationPath("webresources")
//public class AppConfig extends Application {
//
//    @Override
//    public Set<Class<?>> getClasses() {
//        Set<Class<?>> resources = new java.util.HashSet<>();
//        addRestResourceClasses(resources);
//        return resources;
//    }
//
//    /**
//     * Do not modify addRestResourceClasses() method. It is automatically
//     * populated with all resources defined in the project. If required, comment
//     * out calling this method in getClasses().
//     */
//    //LÄGG TILL RESTEN SEN
//    private void addRestResourceClasses(Set<Class<?>> resources) {
//        resources.add(old.api.AlaCarteFacadeREST.class);
//    }
//
//}