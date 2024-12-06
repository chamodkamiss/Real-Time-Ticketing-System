//package com.example.ticketingSystem.controller.service;
//
//import com.example.ticketingSystem.controller.dto.VendorDto;
//import com.example.ticketingSystem.controller.entity.Vendor;
//import com.example.ticketingSystem.controller.repo.VendorRepo;
//import com.example.ticketingSystem.controller.thread.TicketPool;
//import com.example.ticketingSystem.controller.thread.VendorRunnable;
//import jakarta.transaction.Transactional;
//import org.modelmapper.ModelMapper;
//import org.modelmapper.TypeToken;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//@Transactional
//public class VendorService {
//    @Autowired
//    private VendorRepo vendorRepo;
//
//    @Autowired
//    private ModelMapper modelMapper;
//
//    private final TicketPool ticketPool = new TicketPool();
//
//    public Vendor saveVendor(VendorDto vendorDto)
//    {
//        Vendor vendor = modelMapper.map(vendorDto,Vendor.class);
//        return vendorRepo.save(vendor);
//    }
//    public void startVendorThread(VendorDto vendorDto){
//        saveVendor(vendorDto);
//
//        VendorRunnable vendorRunnable = new VendorRunnable(ticketPool , vendorDto);
//        new Thread(vendorRunnable).start();
//    }
//    public int getTicketCount() {
//        return ticketPool.getTicketCount();
//    }
//
//    public List<Vendor> getAllVendors()
//    {
//       return vendorRepo.findAll();
//    }
//
//
//
//
//
//
//}
