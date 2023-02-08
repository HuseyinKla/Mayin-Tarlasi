import java.util.Random;
import java.util.Scanner;

public class MayinTarlasi {
    int rowNumber,columnNumber,total;
    int[][] devMap;
    int[][] playerMap;
    boolean gameSituation = true;

    Scanner scan = new Scanner(System.in);
    Random rand = new Random();

    MayinTarlasi(int row, int col){
        this.rowNumber = row;
        this.columnNumber = col;
        this.devMap=new int[rowNumber][columnNumber];
        this.playerMap=new int[rowNumber][columnNumber];
        this.total = row*col;
    }

    public void run(){
        int whichRow,whichCol;
        System.out.println("\n\nOYUN BASLAMISTIR IYI EGLENCELER");
        prepareTheGame();
        showTable(playerMap);
        while(gameSituation){

            System.out.print("SATIR TAHMININIZ--> ");
            whichRow = scan.nextInt();
            whichRow--;
            System.out.print("SUTUN TAHMININIZ--> ");
            whichCol = scan.nextInt();
            whichCol--;
            if(checkNumber(whichRow,whichCol)==0){
                continue;
            }

            if(devMap[whichRow][whichCol]!=-1){
                playerMap[whichRow][whichCol] = checkMap(whichRow,whichCol);
                if(isPlayerMapFull()){
                    System.out.println("TEBRIKLER OYUNU BASASRIYLA BITIRDINIZ. TEKRAR DENEYINIZ");
                    showTable(playerMap);
                    return;
                }

            }
            else
                gameSituation = false;
            showTable(playerMap);
        }
        System.out.println("\n\nMAALESEF KAYBETTİNİZ. TEKRAR DENEYİNİZ.\n\n");
        showTable(playerMap);
        System.out.println("\n\nMAYINLARIN HARİTASI.\n\n");
        showTable(devMap);

    }


    public void prepareTheGame(){
        int ctrl =0;
        while(total/4!=ctrl){
            if(devMap[rand.nextInt(rowNumber)][rand.nextInt(columnNumber)]!=-1){
                devMap[rand.nextInt(rowNumber)][rand.nextInt(columnNumber)]=-1;
                ctrl++;
            }
        }
    }

    public void showTable(int[][] printArr){
        for(int i=0 ; i<printArr.length ; i++){
            for(int j=0 ; j<printArr[0].length ; j++){
                if(printArr[i][j]>=0)
                    System.out.print(" ");
                System.out.print(printArr[i][j]+" ");
            }
            System.out.println("");
        }
    }

    public int checkMap(int r,int c){
        int counter=0;

        if(c!=columnNumber-1 && devMap[r][c+1]==-1)                         //checking right
            counter++;

        if(c!=0 && devMap[r][c-1]==-1)                                      //checking left
            counter++;

        if(r!=0 && devMap[r-1][c]==-1)                                      //checking up
            counter++;

        if(r!=rowNumber-1 && devMap[r+1][c]==-1)                            //checking down
            counter++;

        if(r!=0 && c!=columnNumber-1 && devMap[r-1][c+1]==-1)               //checking upright
            counter++;

        if(r!=0 && c!=0 && devMap[r-1][c-1]==-1)                            //checking upleft
            counter++;

        if(r!=rowNumber-1 && c!=columnNumber-1 && devMap[r+1][c+1]==-1)     //checking downright
            counter++;

        if(r!=rowNumber-1 && c!=0 && devMap[r+1][c-1]==-1)                  //checking downleft
            counter++;

        if(counter == 0)
            return -2;
        else
            return counter;
    }

    public boolean isPlayerMapFull(){
        int trueCounter=0;
        for(int i=0 ; i<devMap.length ; i++){
            for(int j=0 ; j<devMap[0].length ; j++){
                if(devMap[i][j]==-1)
                    continue;
                if((devMap[i][j]==0 && playerMap[i][j]>0) || (devMap[i][j]==0 && playerMap[i][j]==-2))
                    trueCounter++;
            }
        }
        if(trueCounter==(total-(total/4)))
            return true;
        else
            return false;
    }

    public int checkNumber(int r, int c){

        if(c<=-1 || c>=columnNumber){
            System.out.println("\nYANLIS SAYI GIRDINIZ !!\n");
            return 0;
        }

        if(r<=-1 || r>=rowNumber){
            System.out.println("\nYANLIS SAYI GIRDINIZ !!\n");
            return 0;
        }

        if(playerMap[r][c]!=0){
            System.out.println("\nAYNI YERE TEKRAR SAYI GIREMEZSİNİZ !!\n");
            return 0;
        }
        return 1;
    }


}