import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class MapCreatorRandom {
    ArrayList<String> arrayListGetFight = new ArrayList<>();
    ArrayList<String> arrayListGetRoom = new ArrayList<>();
    ArrayList<Integer> arrayListGetRooms = new ArrayList();
    ArrayList<String> arrayList = new ArrayList<>();
    public MapCreatorRandom() throws IOException {

        File directory = new File("");
        String directoryFile = directory.getCanonicalPath();

        String fullDirectoryMapCreator = directoryFile + "\\src\\run\\MapCreator.txt";

        File fileMapCreator = new File(fullDirectoryMapCreator);

        FileOutputStream fos = null;
        fos = new FileOutputStream(fullDirectoryMapCreator);



        for (int i = 0; i < 64; i++) {
            arrayList.add(i, "[]");
        }

        Random random = new Random();

        int roomR = 6+random.nextInt(2);
        int roomF = 4+random.nextInt(2);
        int roomQ = 2+random.nextInt(1);
        int roomC = 1+random.nextInt(2);


        arrayListGetRooms.add(0,roomR);
        arrayListGetRooms.add(1,roomF);
        arrayListGetRooms.add(2,roomQ);
        arrayListGetRooms.add(3,roomC);


        for (int fight = 0; fight < roomF; fight++) {
            int randomInt = random.nextInt(64);
            if (arrayList.get(randomInt) == "[]") {
                arrayList.set(randomInt, "[fight]");
            } else {
                fight--;
            }
        }
        for (int chest = 0; chest < roomC; chest++) {
            int randomInt = random.nextInt(64);
            if (arrayList.get(randomInt) == "[]") {
                arrayList.set(randomInt, "[chest]");
            } else {
                chest--;
            }
        }
        for (int room = 0; room < roomR; room++) {
            int randomInt = random.nextInt(64);
            if (arrayList.get(randomInt) == "[]") {
                arrayList.set(randomInt, "[room]");
            } else {
                room--;
            }
        }
        for (int question = 0; question < roomQ; question++) {
            int randomInt = random.nextInt(64);
            if (arrayList.get(randomInt) == "[]") {
                arrayList.set(randomInt, "[question]");
            } else {
                question--;
            }
        }

        System.out.println(arrayList);

        ArrayList<String> arrayListEnemy = new ArrayList();

        arrayListEnemy.add(0, "zombie");
        arrayListEnemy.add(1, "ghost");
        arrayListEnemy.add(2, "skeleton");
        arrayListEnemy.add(3, "spider");
        arrayListEnemy.add(4, "slug");
        arrayListEnemy.add(5, "skeletonWarrior");
        arrayListEnemy.add(6, "bandit");

        ArrayList<String> arrayListRoomItem = new ArrayList();

        arrayListRoomItem.add(0, "box");
        arrayListRoomItem.add(1, "candlestick");
        arrayListRoomItem.add(2, "tree");
        arrayListRoomItem.add(3, "chest");
        arrayListRoomItem.add(4, "pine-tree");



        int tFight = 0;

        for (int i = 0; i < 64; i++) {
            if(arrayList.get(i) == "[fight]") {
                System.out.println("if");
                int rand = random.nextInt(6);
                int rand2 = random.nextInt(6);
                arrayList.set(i,"[fight"+tFight+" ["+arrayListEnemy.get(rand)+","+arrayListEnemy.get(rand2)+"] ]");
                tFight++;
                String result = arrayList.get(i);
                arrayListGetFight.add(result);

            } else {

                System.out.println("else");
            }
        }
        int tRoom = 0;
        for (int i = 0; i < 64; i++) {
            if(arrayList.get(i) == "[room]") {
                System.out.println("if");
                int rand = random.nextInt(4);
                int rand2 = random.nextInt(4);
                arrayList.set(i,"[room"+tRoom+" ["+arrayListRoomItem.get(rand)+","+arrayListRoomItem.get(rand2)+"] ]");
                String result = arrayList.get(i);
                arrayListGetRoom.add(result);
                tRoom++;
            } else {

                System.out.println("else");
            }
        }




        //System.out.println(arrayListGetRoom);
        //System.out.println(arrayListGetFight);



        System.out.println(arrayList);

        String s = "[]";

        FileWriter fileWriter = new FileWriter(fullDirectoryMapCreator);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        int ss = 0;



            for (int i = 0;i<8;i++) {
                for(int r = 0;r<8;r++) {

                    bufferedWriter.write(arrayList.get(ss));
                    ss++;
                }
                bufferedWriter.append('\n');
            }
            bufferedWriter.close();

        //bufferedWriter.write(s+" "+s+" "+s+" "+s+" "+s+" "+s+" "+s+" "+s);
        //bufferedWriter.append('\n');
       // bufferedWriter.write(s+" "+s+" "+s+" "+s+" "+s+" "+s+" "+s+" "+s);
        //bufferedWriter.append('\n');
        //bufferedWriter.write(s+" "+s+" "+s+" "+s+" "+s+" "+s+" "+s+" "+s);
       // bufferedWriter.append('\n');
       // bufferedWriter.write(s+" "+s+" "+s+" "+s+" "+s+" "+s+" "+s+" "+s);
       // bufferedWriter.append('\n');
       // bufferedWriter.write(s+" "+s+" "+s+" "+s+" "+s+" "+s+" "+s+" "+s);
       // bufferedWriter.append('\n');
       // bufferedWriter.write(s+" "+s+" "+s+" "+s+" "+s+" "+s+" "+s+" "+s);
       // bufferedWriter.append('\n');
       // bufferedWriter.write(s+" "+s+" "+s+" "+s+" "+s+" "+s+" "+s+" "+s);
    //    bufferedWriter.append('\n');
       // bufferedWriter.write(s+" "+s+" "+s+" "+s+" "+s+" "+s+" "+s+" "+s);
     //   bufferedWriter.close();

        FileReader fr = new FileReader(fullDirectoryMapCreator);
        //создаем BufferedReader с существующего FileReader для построчного считывания
        BufferedReader reader = new BufferedReader(fr);
        // считаем сначала первую строку
        String line = reader.readLine();
        while (line != null) {
            //System.out.println(line);
            // считываем остальные строки в цикле
            line = reader.readLine();
            System.out.println(line+"line_________________");

        }




    }

    public ArrayList<String> getRoom() {
        return arrayListGetRoom;
    }
    public ArrayList<String> getFight() {
        return arrayListGetFight;
    }
    public ArrayList<Integer> getRooms() {
        return arrayListGetRooms;
    }
    public ArrayList<String> getAll() {return arrayList;}
}
