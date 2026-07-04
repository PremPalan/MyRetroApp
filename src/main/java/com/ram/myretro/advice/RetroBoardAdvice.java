package com.ram.myretro.advice;

import com.ram.myretro.board.RetroBoard;
import com.ram.myretro.exception.RetroBoardNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Optional;

import java.util.UUID;

@Slf4j
@Component
@Aspect
public class RetroBoardAdvice {

    @Around("execution(* com.ram.myretro.persistance.RetroBoardRepository.findById(java.util.UUID))")
    public Object checkFindRetroBoard(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        log.info("[ADVICE] findRetroBoardById");

        Optional<RetroBoard> retroBoard = (Optional<RetroBoard>) proceedingJoinPoint.proceed(new Object[]{UUID.fromString(proceedingJoinPoint.getArgs()[0].toString())});

        if (retroBoard.isEmpty()) throw new RetroBoardNotFoundException();

        return retroBoard;
    }
}


// @Aspect: This annotation is a marker for a class and tells the Spring
// Framework that the class has an Aspect that will contain an Advice
// (Before, After, Around, AfterReturn, AfterThrowing) that will
// be intercepting a particular method depending on the matcher
// declaration. Behind the scenes, Spring creates proxies for these
// classes and applies everything related to AOP.

// @Around. This annotation is one of the many annotations to create
// Advice. In this case, it will intercept the call (based on the execution
// declaration that matches the method) before it gets executed, create
// an instance of the ProceedingJoinPoint, and execute the method
// you marked with this annotation and execute your logic. Then,
// you can execute the actual call, do some more logic, and return
// the result. Related annotations are the @Before advice, which will
// execute your method logic before the actual call happens, the @After
// advice, which will execute your method logic after the call, and the
// @AfterReturning advice, which will execute the logic when

// execution: This is the key to the Advice. This keyword needs a
// pattern matching that identifies the method to be advised. In this
// case, we are looking for every method with any return type (*)
// and looking for that specific method in the com.apress.myretro.
// repository.RetroBoardRepository.findById that has as a
// parameter the UUID. In this case, this is very straightforward, but we
// can have an expression like this: * com.apress.*..*.find*(*). This
// means finding any class that is between the package apress and up
// and any class that has the find prefix for the method that accepts any
// number of parameters, no matter the type.

// ProceedingJoinPoint: This is an interface, and its
// implementation knows how to get the object that is being advised
// (RetroBoardRepository.findById); it has the actual object, and we
// can call the proceed that will execute it, and we can get the result
// and return it. See that we can manipulate the result or even the
// parameters that we are sending. Only the Around Advice must have
// this ProceedingJoinPoint.