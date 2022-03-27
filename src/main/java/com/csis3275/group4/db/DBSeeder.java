package com.csis3275.group4.db;

import com.csis3275.group4.entity.*;
import com.csis3275.group4.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Component
public class DBSeeder implements CommandLineRunner {
    private TableRepository tableRepository;
    private ServiceRepository serviceRepository;
    private StaffRepository staffRepository;
    private BookingRepository bookingRepository;
    private UserRepository userRepository;

    public DBSeeder(TableRepository tableRepository, ServiceRepository serviceRepository, StaffRepository staffRepository,BookingRepository bookingRepository, UserRepository userRepository) {
        this.tableRepository = tableRepository;
        this.serviceRepository = serviceRepository;
        this.staffRepository = staffRepository;
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        bookingRepository.deleteAll();
        Booking testBooking = new Booking();
        testBooking.setBookingTime(LocalTime.of(22,00));
        testBooking.setBookingDate(LocalDate.of(2021,04,06));
        //create tables
        Table table1 = new Table(
            "Table1",
                4,
                true
        );
        Table table2 = new Table(
                "Table2",
                4,
                false
        );
        Table table3= new Table(
                "Table3",
                4,
                true
        );
        Table table4 = new Table(
                "Table4",
                4,
                true
        );
        Table table5 = new Table(
                "Table5",
                6,
                false
        );
        Table table6 = new Table(
                "Table6",
                6,
                true
        );
        Table table7 = new Table(
                "Table7",
                8,
                true
        );
        Table table8 = new Table(
                "Table8",
                8,
                true
        );
        Table table9 = new Table(
                "Table9",
                10,
                true
        );
        Table table10 = new Table(
                "Table10",
                10,
                true
        );
        Table table11 = new Table(
                "Table11",
                10,
                true
        );

        // drop all tables
        this.tableRepository.deleteAll();

        // add tables to database
        List<Table> tables = Arrays.asList(table1, table2, table3, table4, table5, table6, table7, table8, table9, table10, table11);
        this.tableRepository.saveAll(tables);

        testBooking.getTables().add(table1);
        bookingRepository.save(testBooking);
        // create services
        Service service1 = new Service(
                "Lunch",
                40
        );
        Service service2 = new Service(
                "Dinner",
                50
        );
        Service service3 = new Service(
                "Special Meal",
                60
        );
        Service service4 = new Service(
                "Birthday Party",
                70
        );
        Service service5 = new Service(
                "Family Party",
                50
        );
        Service service6 = new Service(
                "Wedding Party",
                100
        );
        Service service7 = new Service(
                "Company Party",
                80
        );

        // drop all services
        serviceRepository.deleteAll();

        // add services
        List<Service> services = Arrays.asList(service1, service2, service3, service4, service5, service6, service7);
        this.serviceRepository.saveAll(services);

        // create staffs
        Staff staff1 = new Staff(
                "Olivia Smith",
                LocalDate.of(1990, 2, 20),
                "2356 Kingsway, Vancouver, BC",
                Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        );

        Staff staff2 = new Staff(
                "Liam Jones",
                LocalDate.of(1994, 03, 23),
                "1235 Victoria, Vancouver, BC",
                Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        );
        Staff staff3 = new Staff(
                "Joe Brown",
                LocalDate.of(1995, 05, 13),
                "4156 14th East Ave, Vancouver, BC",
                Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        );
        Staff staff4 = new Staff(
                "Tracy Li",
                LocalDate.of(1998, 01, 30),
                "3457 Rupert, Vancouver, BC",
                Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        );
        Staff staff5 = new Staff(
                "Julie Wilson",
                LocalDate.of(1990, 2, 12),
                "4598 Vitoria, Vancouver, BC",
                Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        );
        Staff staff6 = new Staff(
                "Brian Davis",
                LocalDate.of(1997, 10, 20),
                "1234 Slocan, Vancouver, BC",
                Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        );
        Staff staff7 = new Staff(
                "Anna Li",
                LocalDate.of(1997, 12, 22),
                "3421 Cambridge, Vancouver, BC",
                Arrays.asList("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
        );

        // drop all staffs
        this.staffRepository.deleteAll();

        // add staffs
        List<Staff> staffList = Arrays.asList(staff1, staff2, staff3, staff4, staff5, staff6, staff7);
        this.staffRepository.saveAll(staffList);

        // Users
        //drop all users
        userRepository.deleteAll();

        // create users
        User admin = new User(
            "admin",
            "12345678"
        );
        User user = new User(
            "anurag@gmail.com",
            "12345678"
        );
        User user1 = new User(
                "brian@gmail.com",
                "12345678"
        );
        User user2 = new User(
            "bao@gmail.com",
            "12345678"
        );
        User user3 = new User(
            "victoria@gmail.com",
            "12345678"
        );

        List<User> users = Arrays.asList(admin, user, user1, user2, user3);
        this.userRepository.saveAll(users);
    }
}
