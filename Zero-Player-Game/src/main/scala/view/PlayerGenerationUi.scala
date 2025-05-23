package view

import scalafx.Includes._
import scalafx.application.JFXApp3
import scalafx.scene.Scene
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle

object PlayerGenerationUi extends JFXApp3:
  override def start(): Unit =
    stage = new JFXApp3.PrimaryStage:
      title.value = "Generate your player"
      width = 600
      height = 450
      scene = new Scene:
        fill = LightPink
        content = new Rectangle:
          x = 25
          y = 40
          width = 100
          height = 100
          //fill <== when(hover) choose Green otherwise LightPink


