package controller;

import domain.Ladder;
import view.LadderItem;
import domain.Line;
import domain.Participant;
import domain.Participants;
import util.LadderItemGenerator;
import view.InputView;
import view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class LadderGame {

    private final InputView inputView;
    private final OutputView outputView;
    private final LadderItemGenerator ladderItemGenerator;

    public LadderGame(InputView inputView, OutputView outputView, LadderItemGenerator ladderItemGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.ladderItemGenerator = ladderItemGenerator;
    }

    public void start() {
        Participants participants = makeParticipants(inputName());
        Ladder ladder = new Ladder(inputHeight());

        ladder.makeLadder(participants.getParticipantsCount(), ladderItemGenerator);
        printLadder(ladder, participants);
    }

    private List<String> inputName() {
        String input = inputView.inputName();

        return List.of(input.split(","));
    }

    private Participants makeParticipants(List<String> names) {
        return new Participants(names);
    }

    private String inputHeight() {
        return inputView.inputHeight();
    }

    private void printLadder(Ladder ladder, Participants participants) {
        List<String> result = new ArrayList<>();
        List<Line> createdLadder = ladder.getLadder();

        createParticipantsLineUp(result, participants.getParticipants());
        createLadder(result, createdLadder);

        outputView.printLadder(result);
    }

    private void createParticipantsLineUp(List<String> result, List<Participant> participants) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Participant participant : participants) {
            stringBuilder.append(String.format("%5s ", participant.getName()));
        }

        result.add(stringBuilder.toString());
    }

    private void createLadder(List<String> result, List<Line> createdLadder) {
        for (Line line : createdLadder) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("    |");

            createLine(line, stringBuilder);

            result.add(stringBuilder.toString());
        }
    }

    private void createLine(Line line, StringBuilder stringBuilder) {
        for (LadderItem point : line.getPoints()) {
            stringBuilder.append(point.getShape());
        }
    }
}
