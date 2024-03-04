package com.intellibucket.lib.payload.payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SkillPayload extends Payload {
    private UUID skillId;
}
