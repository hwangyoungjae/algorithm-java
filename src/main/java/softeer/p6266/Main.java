package softeer.p6266;

import java.text.DecimalFormat;
import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int M;

    public static void main(String... args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        List<String> names = new ArrayList<>(N);
        Map<String, Room> rooms = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String roomName = bf.readLine();
            names.add(roomName);
            rooms.put(roomName, new Room(roomName));
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(bf.readLine());
            String r = st2.nextToken();
            rooms.get(r).addReservation(new RoomReservation(Integer.parseInt(st2.nextToken()), Integer.parseInt(st2.nextToken())));
        }

        Collections.sort(names);
        for (int i = 0; i < names.size(); i++) {
            String roomName = names.get(i);
            System.out.printf("Room %s:%n", roomName);
            List<RoomReservation> available = rooms.get(roomName).getAvailable();

            if (available.size() > 0) {
                System.out.printf("%d available:%n", available.size());
                for (RoomReservation rr : available) {
                    System.out.println(rr);
                }
            } else {
                System.out.println("Not available");
            }

            if (i + 1 < names.size()) {
                System.out.println("-----");
            }
        }
    }
}

class Room {

    private static final int ROOM_S = 9;
    private static final int ROOM_T = 18;
    private static final int T = ROOM_T - ROOM_S;
    private String name;
    /**
     * 0: 09-10
     * 1: 10-11
     * 2: 11-12
     * 3: 12-13
     * 4: 13-14
     * 5: 14-15
     * 6: 15-16
     * 7: 16-17
     * 8: 17-18
     **/
    private boolean[] reservation;

    public Room(String name) {
        this.name = name;
        reservation = new boolean[T];
    }

    public void addReservation(RoomReservation rr) {
        for (int i = rr.getS(); i < rr.getT(); i++) {
            reservation[i - ROOM_S] = true;
        }
    }

    public List<RoomReservation> getAvailable() {
        List<RoomReservation> available = new ArrayList<>();
        int s = 0;
        int t = 0;
        for (int i = 0; i < reservation.length; i++) {
            if (reservation[i]) {
                if (s != 0) {
                    available.add(new RoomReservation(s, t));
                    s = 0;
                    t = 0;
                }
            } else {
                if (s == 0) {
                    s = i + ROOM_S;
                }
                t = i + ROOM_S + 1;
            }
        }
        if (s != 0) {
            available.add(new RoomReservation(s, t));
        }
        return available;
    }
}

class RoomReservation {
    private int s;
    private int t;

    public int getS() {
        return s;
    }

    public int getT() {
        return t;
    }

    public RoomReservation(int s, int t) {
        this.s = s;
        this.t = t;
    }

    @Override
    public String toString() {
        return String.format("%s-%s",
                new DecimalFormat("00").format(s),
                new DecimalFormat("00").format(t)
        );
    }
}
