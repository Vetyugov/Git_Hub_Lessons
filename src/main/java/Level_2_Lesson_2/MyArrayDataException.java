package Level_2_Lesson_2;
//Исключение
    class MyArrayDataException extends NumberFormatException{
        private String position;
        MyArrayDataException (String position){
            this.position = position;
        }
        public void printMessage(){
            System.out.println("Не верный символ на позиции:"+ position);
        }
    }

