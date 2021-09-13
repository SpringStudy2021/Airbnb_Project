package com.example.reservation.persistence;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

//MapppedSuperClass
//JPA Entity 클래스들이 추상클래스BaseTimeEntity를 상속할 경우
// 필드들(createdDate, modifiedDate)도 칼럼으로 인식하도록 합니다

//EntityListner에
// BaseTimeEntiy 클래스에 jpa Auditing 기능을 포함시킵니다.

// audit는 감시하다 라는 뜻으로 데이터베이스에 레코드를 삽입 수정하는 기록을 감시하여
// 자동으로 기록을 데이터베이스에 저장해주는 기능을 jpa auditing 이라고 한다.

// EntityListner는 Jpa Entity에 관하여 이벤트가 발생했을때 특정로직을 수행할 수 있도록 만들수있는 기능
// 보통 디비 삽입전 혹은 삽입후 수행할수있는 로직을 만들 수 있음

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public  class BaseTimeEntity {

    @CreatedDate
    private LocalDateTime createdDate;
// Entity가 생성되어 저장될 때 시간이 자동 저장
    @LastModifiedDate
    private LocalDateTime modifiedDate;
//조회한 Entity의 값을 변경할 때 시간이 자동 저장
}
