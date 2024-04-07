package edu.miu.springaop.aop.aspect;

import edu.miu.springaop.entity.ActivityLog;
import edu.miu.springaop.repository.ActivityLogRepository;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAdvice {

    private final ActivityLogRepository activityLogRepository;

    @Pointcut("@annotation(edu.miu.springaop.aop.annotation.ExecutionTime)")
    public void executionTimeAnnotation() {}

    @Around("executionTimeAnnotation()")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.nanoTime();
        var result = joinPoint.proceed();
        long duration = System.nanoTime() - start;
        activityLogRepository.save(new ActivityLog(null, LocalDate.now(), joinPoint.getSignature().getName(), duration));
        return result;
    }

}
