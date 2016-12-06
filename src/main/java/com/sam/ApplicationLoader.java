package com.sam;

import com.sam.domain.Item;
import com.sam.repository.ItemRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by samchu on 2016/12/6.
 */
@Component
public class ApplicationLoader implements CommandLineRunner {

    @Autowired
    private ItemRep itemRep;

    @Override
    public void run(String... args) throws Exception {

        Item item = new Item();
        item.setName("KUWO K1音樂運動無線藍芽耳機");
        item.setPrice(980);
        itemRep.save(item);
        item = new Item();
        item.setName("棉麻休閒格子襯衫外套長袖棉麻上衣");
        item.setPrice(520);
        itemRep.save(item);
        item = new Item();
        item.setName("94Liberty–簡約風帆布手提包");
        item.setPrice(290);
        itemRep.save(item);

    }
}
