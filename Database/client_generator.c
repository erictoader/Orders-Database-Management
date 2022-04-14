#include <stdlib.h>
#include <stdio.h>
#include <time.h>

int randomPhoneNumber()
{
    int phoneNumber = 0;

    for(int i = 0; i < 10; i++)
    {
        phoneNumber += rand() % 10;
        phoneNumber *= 10;
    }
    return abs(phoneNumber);
}

int main(int argc, char** argv)
{
    FILE* fp = fopen("clients.txt", "w");
    char lNameList[10][30] = {"Popescu", "Ciocoiu", "Feleac", "Popa", "Rusu", "Ardelean", "Moldovan", "Toader", "Pascale", "Bunea"};
    char fNameList[10][30] = {"Radu", "Andrei", "Stefan", "Marian", "Cristian", "Daria", "Lorena", "Bianca", "Sebastian", "Miruna"};
    char adressList[10][30] = {"Plopilor", "Timpului", "Frunzisului", "Observatorului", "Dambovitei", "Alunisului", "Izvorului", "Lopatarului", "Salcamului", "Memorandumului"};

    fprintf(fp, "INSERT INTO `client` (`last_name`, `first_name`, `phone_number`, `address`)\nVALUES\n");
    srand(time(NULL));
    for(int i = 0; i < 100; i++)
    {
        fprintf(fp, "('%s', '%s', '%d', '%s %d')", lNameList[rand() % 10], fNameList[rand() % 10], randomPhoneNumber(), adressList[rand() % 10], 1 + rand() % 100);
        if(i == 99)
        {
            fprintf(fp, ";");
        }
        else fprintf(fp, ",\n");
    }

    printf("DONE\n");
    fclose(fp);
    return 0;

}