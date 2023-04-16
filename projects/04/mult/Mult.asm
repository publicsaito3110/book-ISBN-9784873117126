// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Mult.asm

// Multiplies R0 and R1 and stores the result in R2.
// (R0, R1, R2 refer to RAM[0], RAM[1], and RAM[2], respectively.)
//
// This program only needs to handle arguments that satisfy
// R0 >= 0, R1 >= 0, and R0*R1 < 32768.

  // Answer
  
  // Set R2 = 0
  @R2
  M = 0
  
  // Set i = 0
  @i
  M = 1
  
  (LOOP)
    
    // Call i
    @i
    D = M
    
    // Call R1 And Set R1 = i - R1
    @R1
    D = D - M
    
    // Loop End Condition 0 < R1
    @END
    D;JGT
    
    // Call R0
    @R0
    D = M
    
    // Call R2 And Set R2 = R2 + R0
    @R2
    M = M + D
  
    // Call i And Set i++
    @i
    M = M + 1
    
    // Back Loop's Start
    @LOOP
    0;JMP
  (END)
    
    // Back Loop's Start
    @END
    0;JMP