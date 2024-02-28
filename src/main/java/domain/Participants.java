package domain;

import java.util.*;

public class Participants {

    private final List<Participant> participants = new ArrayList<>();

    public Participants(List<String> names) {
        validateNamesLength(names);
        validateDuplicatedNames(names);

        makeParticipants(names);
    }

    private void validateNamesLength(List<String> names) {
        if (names.size() == 0) {
            throw new IllegalArgumentException("참가자는 한 명 이상 입력해야 합니다.");
        }
    }

    private void validateDuplicatedNames(List<String> names) {
        if (names.size() != Set.copyOf(names).size()) {
            throw new IllegalArgumentException("참가자의 이름은 중복될 수 없습니다.");
        }
    }

    private void makeParticipants(List<String> names) {
        for (String name : names) {
            participants.add(new Participant(name));
        }
    }

    public Participant findParticipantByName(String name) {
        return participants.stream()
                .filter(participant -> participant.getName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 참가자 이름입니다."));
    }

    public Participant findParticipantByInitPosition(int position) {
        return participants.get(position);
    }

    public int getParticipantsCount() {
        return participants.size();
    }
}
