package src;
public class Controller {
    private int WrongCount = 0;
    private int CorrectCount = 0;

    public void AddWrongCount() {
        WrongCount++;
    }

    public void AddCorrectCount() {
        CorrectCount++;
    }

    public int GetWrongCount() {
        return WrongCount;
    }

    public int GetCorrectCount() {
        return CorrectCount;
    }

    public void ResetCorrectCount() {
        CorrectCount = 0;
    }


}
