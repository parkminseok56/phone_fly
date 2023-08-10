package com.ezen.phonefly2.dto;

public class KakaoProfile {

   // 카카오 프로필 정보를 담는 데이터 객체입니다.
   // 내부에 중첩된 클래스들을 통해 프로필의 다양한 정보를 저장하고, getter 및 setter 메서드를 통해 접근할 수 있도록 구성되어 있습니다.

    private String id; // 카카오 프로필의 아이디
    
    private KakaoAccount kakao_account; // 카카오 계정 정보

    // 카카오 계정 정보의 getter 메서드
    public KakaoAccount getAccount() {
        return kakao_account;
    }

    // 아이디 getter 메서드
    public String getId() {
        return id;
    }

    // 카카오 계정 정보를 나타내는 내부 클래스
    public class KakaoAccount {
        
        private Profile profile; // 프로필 정보
        private String email; // 이메일
        private boolean has_email; // 이메일 보유 여부

        // 프로필 정보의 getter 메서드
        public Profile getProfile() {
            return profile;
        }
        
        // 프로필 정보의 setter 메서드
        public void setProfile(Profile profile) {
            this.profile = profile;
        }

        // 이메일 getter 메서드
        public String getEmail() {
            return email;
        }

        // 이메일 setter 메서드
        public void setEmail(String email) {
            this.email = email;
        }

        // 이메일 보유 여부 getter 메서드
        public boolean isHas_email() {
            return has_email;
        }

        // 이메일 보유 여부 setter 메서드
        public void setHas_email(boolean has_email) {
            this.has_email = has_email;
        }

        // 프로필 정보를 나타내는 내부 클래스
        public class Profile {
            private String nickname; // 닉네임
            private String profile_image_url; // 프로필 이미지 URL
            
            // 닉네임 getter 메서드
            public String getNickname() {
                return nickname;
            }

            // 닉네임 setter 메서드
            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            // 프로필 이미지 URL getter 메서드
            public String getProfile_image_url() {
                return profile_image_url;
            }

            // 프로필 이미지 URL setter 메서드
            public void setProfile_image_url(String profile_image_url) {
                this.profile_image_url = profile_image_url;
            }
        }
    }
}
