package com.springbootacademy.pointofsale.service.impl;

import com.springbootacademy.pointofsale.dto.request.RequestItemSaveDTO;
import com.springbootacademy.pointofsale.entity.Item;
import com.springbootacademy.pointofsale.repo.ItemRepo;
import com.springbootacademy.pointofsale.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    private ItemRepo itemRepo;

    @Override
    public String addItem(RequestItemSaveDTO requestItemSaveDTO) {
        Item item = modelMapper.map(requestItemSaveDTO,Item.class);

        if(!itemRepo.existsById(item.getItemId())){
            itemRepo.save(item);
            return "save successful";
        }else {
            System.out.println("Already exist");
        }




        return"item added.";


    }
}
