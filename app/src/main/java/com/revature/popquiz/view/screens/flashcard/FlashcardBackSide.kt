package com.revature.popquiz.view.screens.flashcard

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout


@Composable
fun FlashCardBackSide(flipController: FlippableController,answer:String) {
    Box(modifier = Modifier) {
        Surface(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
                .height(220.dp),
            shape = RoundedCornerShape(20.dp),
            color = Color(0xFFECECEC),
            elevation = 16.dp
        ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                ConstraintLayout(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val (txtShuffleWord, txtWord, txtMeaning, txtExample, txtExampleAnswer, btnDontKnow, btnKnow) = createRefs()

                    Text(
                        text = answer,
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .constrainAs(txtWord) {
                                linkTo(
                                    start = parent.start,
                                    end = parent.end
                                )
                                linkTo(
                                    top = parent.top,
                                    bottom = parent.bottom
                                )
//                                start.linkTo(parent.start)
//                                top.linkTo(parent.top)
                            }
                            .padding(top = 16.dp, start = 16.dp)
                    )

//                    Text(
//                        text = "Flip to front",
//                        style = MaterialTheme.typography.subtitle2,
//                        maxLines = 1,
//                        color = Color(0xFF696969),
//                        modifier = Modifier
//                            .constrainAs(txtMeaning) {
//                                start.linkTo(txtWord.start)
//                                top.linkTo(txtWord.bottom)
//                            }
//                            .padding(start = 16.dp)
//                    )
//
//                    Text(
//                        text = "Example",
//                        style = MaterialTheme.typography.h6,
//                        maxLines = 1,
//                        fontWeight = FontWeight.SemiBold,
//                        modifier = Modifier
//                            .constrainAs(txtExample) {
//                                top.linkTo(txtMeaning.bottom)
//                                start.linkTo(txtMeaning.start)
//                            }
//                            .padding(top = 16.dp, start = 16.dp)
//                    )
//
//                    Text(
//                        text = "Definition will be written here",
//                        style = MaterialTheme.typography.subtitle2,
//                        color = Color(0xFF696969),
//                        modifier = Modifier
//                            .constrainAs(txtExampleAnswer) {
//                                start.linkTo(txtExample.start)
//                                top.linkTo(txtExample.bottom)
//                            }
//                            .padding(start = 16.dp, end = 16.dp)
//                    )
//
//                    Text(
//                        text = "I don't know",
//                        style = MaterialTheme.typography.subtitle2,
//                        color = Color(0xFF8B1818),
//                        maxLines = 1,
//                        modifier = Modifier
//                            .constrainAs(btnDontKnow) {
//                                start.linkTo(parent.start)
//                                bottom.linkTo(parent.bottom)
//                            }
//                            .padding(bottom = 16.dp, start = 16.dp)
//                            .clickable(
//                                indication = rememberRipple(color = MaterialTheme.colors.primary),
//                                interactionSource = remember { MutableInteractionSource() },
//                            ) {
//                                flipController.flip()
//                            }
//                    )
//
//                    Text(
//                        text = "I understand this topic",
//                        style = MaterialTheme.typography.subtitle2,
//                        color = Color(0xFF3588C7),
//                        maxLines = 1,
//                        modifier = Modifier
//                            .constrainAs(btnKnow) {
//                                end.linkTo(parent.end)
//                                bottom.linkTo(parent.bottom)
//                            }
//                            .padding(bottom = 16.dp, end = 16.dp)
//                            .clickable(
//                                indication = rememberRipple(color = MaterialTheme.colors.primary),
//                                interactionSource = remember { MutableInteractionSource() },
//                            ) {
//                                flipController.flip()
//                            }
//                    )
                }
            }
        }
    }
}