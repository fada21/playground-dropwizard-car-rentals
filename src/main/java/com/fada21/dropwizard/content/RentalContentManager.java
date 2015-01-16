package com.fada21.dropwizard.content;

import com.fada21.dropwizard.model.Rental;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class RentalContentManager extends BaseMockedContentManager<Rental> {

    private final AtomicLong SEQUENCE = new AtomicLong(3);

    private final long DAY = TimeUnit.DAYS.toSeconds(1);
    private final long HOUR = TimeUnit.HOURS.toSeconds(1);
    private final long DATE20140202 = 1391342400; // 02/02/2014 12:000:000

    @Getter
    @NonNull
    final AccountContentManager accountContentManager;
    @Getter
    @NonNull
    final VehicleContentManager vehicleContentManager;

    private final Map<Long, Rental> rentalMap = new ConcurrentHashMap<>();

    public RentalContentManager(AccountContentManager accountContentManager, VehicleContentManager vehicleContentManager) {
        this.accountContentManager = accountContentManager;
        this.vehicleContentManager = vehicleContentManager;

        Rental.RentalBuilder builder = Rental.builder();
        rentalMap.put(1l, builder.id(1).accountId(2).vehicleId(1).startHire(DATE20140202 - DAY).endHire(DATE20140202).build());
        rentalMap.put(2l, builder.id(2).accountId(3).vehicleId(3).startHire(DATE20140202).endHire(DATE20140202 + 2 * HOUR).build());
    }

    @Override
    protected Map<Long, Rental> getMockMap() {
        return rentalMap;
    }

    public Long getNextId() {
        return SEQUENCE.getAndIncrement();
    }

    public List<Rental> findOngoing() {
        return findByState(true);
    }

    public List<Rental> findFinished() {
        return findByState(false);
    }

    private List<Rental> findByState(final boolean isActive) {
        List<Rental> rentals = new ArrayList<>();
        for (Rental r : findAll()) {
            if (!isActive != r.getEndHire() > 0) {
                rentals.add(r);
            }
        }
        return rentals;
    }


}
