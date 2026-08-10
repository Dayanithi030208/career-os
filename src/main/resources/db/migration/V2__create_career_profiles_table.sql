CREATE TABLE career_profiles (
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL UNIQUE,
    target_role VARCHAR(100) NOT NULL,
    current_level VARCHAR(50) NOT NULL,
    career_goal TEXT,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP NOT NULL,

    CONSTRAINT fk_career_profile_user
        FOREIGN KEY (user_id)
        REFERENCES users(id)
        ON DELETE CASCADE
);