public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        // проверяем, что все координаты в пределах доски:
        if (checkPos(line) && checkPos(column) && checkPos(toLine) && checkPos(toColumn) &&
                // и стартовая клетка не пустая
                chessBoard.board[line][column] != null) {
            if (column == toColumn){
                // на сколько клеток вперёд можно ходить
                int dir;
                int start;
                if (color.equals("White")){
                        // направление хода белых вверх "+"
                        dir = 1;
                        start = 1;
                }
                else {
                    dir = -1;
                    // линия старта чёрных "6"
                    start = 6;
                }
                // проверяем можно ли сходить в конечную клетку, свободна ли она
                if (line + dir == toLine) {
                    return chessBoard.board[toLine][toColumn] == null;
                }
                // если линия = стартовой линии то можем ходить на 2 клетки
                if (line == start && line + 2 * dir == toLine) {
                    // проверяем можно ли сходить в конечную клетку, свободна ли она
                    return chessBoard.board[toLine][toColumn] == null &&
                    // и нет ли на пути других фигур
                    chessBoard.board[line + dir][column] == null;
                }
            }
        } else {
            // если мы едим фигуру по-диагонали
            if ((column - toColumn == 1 || column - toColumn == -1) &&
                (line - toLine == 1 || line - toLine == -1) &&
                // проверяем, что на клетке есть фигура
                    chessBoard.board[toLine][toColumn] != null) {
                return !chessBoard.board[toLine][toColumn].getColor().equals(color);
            } else return false;

        }
        return false;
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    @Override
    public boolean checkPos(int pos) {
        return super.checkPos(pos);
    }
}
