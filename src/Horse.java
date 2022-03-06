public class Horse extends ChessPiece {

    public Horse(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // проверяем, что все координаты в пределах доски:
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn)) {
            // старт не равен конечной координате
            if (line != toLine && column != toColumn &&
                    // и конечная клетка пустая
                    (chessBoard.board[toLine][toColumn] == null ||
                    // или цвет фигуры в конечной клетке НЕ равен цвету текущей фигуры
                    !chessBoard.board[toLine][toColumn].color.equals(this.color)) &&
                    // и стартовая клетка не пустая
                    chessBoard.board[line][column] != null) {
                // если стартовая клетка НЕ равна коню то ходить нельзя
                if (!chessBoard.board[line][column].equals(this)) {
                    return false;
                }
                // все возможные позиции для коня
                int[][] positions = new int[][]{
                        {line - 2, column - 1}, {line - 2, column + 1},
                        {line + 2, column - 1}, {line + 2, column + 1},
                        {line - 1, column - 2}, {line - 1, column + 2},
                        {line + 1, column - 2}, {line + 1, column + 2}};

                // проверяем можно ли сходить исходя из условий position
                for (int i = 0; i < positions.length; i++) {
                    if (positions[i][0] == toLine && positions[i][1] == toColumn)
                        return true;
                }
            }
        } else return false;
        return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    @Override
    public boolean checkPos(int pos) {
        return super.checkPos(pos);
    }
}