package com.fetch.homeexercise.controller;

import com.fetch.homeexercise.model.Item;
import com.fetch.homeexercise.model.Receipt;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {
    private final Map<String, Integer> receipts = new HashMap<>();

    @PostMapping("/process")
    public Map<String, String> processReceipt(@RequestBody Receipt receipt) {
        //I used UUID for randome id...
        String id = UUID.randomUUID().toString();
        int points = calculatePointsViaRules(receipt);
        receipts.put(id, points);
        return Collections.singletonMap("id", id);
    }

    @GetMapping("/{id}/points")
    public Map<String, Integer> getPoints(@PathVariable String id) {
        if (!receipts.containsKey(id)) {
            return Collections.singletonMap("No receipt ID Found. Therefore, points=", 0);
        }
        return Collections.singletonMap("points", receipts.get(id));
    }

    private int calculatePointsViaRules(Receipt receipt) {
        int points = (int) receipt.getRetailer().chars().filter(Character::isLetterOrDigit).count();

        double total = Double.parseDouble(receipt.getTotal());
        if (total == Math.floor(total)) {
            points += 50;
        }
        if (total % 0.25 == 0) {
            points += 25;
        }
        points += (receipt.getItems().size() / 2) * 5;

        for (Item item : receipt.getItems()) {
            if (item.getShortDescription().trim().length() % 3 == 0) {
                points += Math.ceil(Double.parseDouble(item.getPrice()) * 0.2);
            }
        }

        LocalDate date = LocalDate.parse(receipt.getPurchaseDate());
        if (date.getDayOfMonth() % 2 == 1) points += 6;

        LocalTime time = LocalTime.parse(receipt.getPurchaseTime(), DateTimeFormatter.ofPattern("HH:mm"));
        if (time.getHour() >= 14 && time.getHour() < 16) points += 10;

        //PS: program is not ai generated
        int finalPoints = points;
        return finalPoints;
    }
}
