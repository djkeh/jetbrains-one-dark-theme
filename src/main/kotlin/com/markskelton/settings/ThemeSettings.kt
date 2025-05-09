package com.markskelton.settings

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.components.PersistentStateComponent
import com.intellij.openapi.components.State
import com.intellij.openapi.components.Storage
import com.intellij.util.xmlb.XmlSerializerUtil

@State(
    name = "OneDarkConfig",
    storages = [Storage("one_dark_config.xml")]
)
class ThemeSettings : PersistentStateComponent<ThemeSettings>, Cloneable {
  companion object {
    val instance: ThemeSettings
      get() = ApplicationManager.getApplication().getService(ThemeSettings::class.java)
  }

  var version: String = "0.0.0"
  var userId: String = ""

  override fun getState(): ThemeSettings? =
      XmlSerializerUtil.createCopy(this)

  override fun loadState(state: ThemeSettings) {
    XmlSerializerUtil.copyBean(state, this)
  }

  fun asJson(): Map<String, Any> = mapOf(
    "version" to version
  )
}
