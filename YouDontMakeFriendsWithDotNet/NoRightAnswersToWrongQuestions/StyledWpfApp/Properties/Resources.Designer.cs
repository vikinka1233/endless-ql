﻿//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//     Runtime Version:4.0.30319.42000
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace StyledWpfApp.Properties {
    using System;
    
    
    /// <summary>
    ///   A strongly-typed resource class, for looking up localized strings, etc.
    /// </summary>
    // This class was auto-generated by the StronglyTypedResourceBuilder
    // class via a tool like ResGen or Visual Studio.
    // To add or remove a member, edit your .ResX file then rerun ResGen
    // with the /str option, or rebuild your VS project.
    [global::System.CodeDom.Compiler.GeneratedCodeAttribute("System.Resources.Tools.StronglyTypedResourceBuilder", "4.0.0.0")]
    [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
    [global::System.Runtime.CompilerServices.CompilerGeneratedAttribute()]
    internal class Resources {
        
        private static global::System.Resources.ResourceManager resourceMan;
        
        private static global::System.Globalization.CultureInfo resourceCulture;
        
        [global::System.Diagnostics.CodeAnalysis.SuppressMessageAttribute("Microsoft.Performance", "CA1811:AvoidUncalledPrivateCode")]
        internal Resources() {
        }
        
        /// <summary>
        ///   Returns the cached ResourceManager instance used by this class.
        /// </summary>
        [global::System.ComponentModel.EditorBrowsableAttribute(global::System.ComponentModel.EditorBrowsableState.Advanced)]
        internal static global::System.Resources.ResourceManager ResourceManager {
            get {
                if (object.ReferenceEquals(resourceMan, null)) {
                    global::System.Resources.ResourceManager temp = new global::System.Resources.ResourceManager("StyledWpfApp.Properties.Resources", typeof(Resources).Assembly);
                    resourceMan = temp;
                }
                return resourceMan;
            }
        }
        
        /// <summary>
        ///   Overrides the current thread's CurrentUICulture property for all
        ///   resource lookups using this strongly typed resource class.
        /// </summary>
        [global::System.ComponentModel.EditorBrowsableAttribute(global::System.ComponentModel.EditorBrowsableState.Advanced)]
        internal static global::System.Globalization.CultureInfo Culture {
            get {
                return resourceCulture;
            }
            set {
                resourceCulture = value;
            }
        }
        
        /// <summary>
        ///   Looks up a localized string similar to form TestQuestionnaire 
        ///{
        ///    q1a: &quot;This is q1a (boolean)?&quot; boolean
        ///    q1b: &quot;This is q1b (boolean)?&quot; boolean
        ///    q1c: &quot;This is q1c (boolean)?&quot; boolean
        ///    q1d: &quot;This is q1d (boolean)?&quot; boolean
        ///    q1e: &quot;This is q1e (boolean)?&quot; boolean
        ///    q1f: &quot;This is q1f (boolean)?&quot; boolean
        ///    q1g: &quot;This is q1g (boolean)?&quot; boolean
        ///    q2a: &quot;This is q2a (date)?&quot; date
        ///    q2b: &quot;This is q2b (date)?&quot; date
        ///    q3: &quot;This is q3 (string)?&quot; string
        ///    q4: &quot;This is q4 (integer)?&quot; integer
        ///    q5: &quot;This is q5 (decimal) [rest of string was truncated]&quot;;.
        /// </summary>
        internal static string ExampleForm {
            get {
                return ResourceManager.GetString("ExampleForm", resourceCulture);
            }
        }
        
        /// <summary>
        ///   Looks up a localized string similar to stylesheet TestStyleSheet 
        ///{
        ///    page page1 
        ///    {
        ///        section section1 
        ///        {
        ///            question q1a 
        ///            question q1b widget checkbox
        ///            question q1c {width: 50 font: &quot;Comic Sans&quot; color: #FFFF0000 }
        ///            question q1d {widget radio color: #FFF0F000 }
        ///            question q1e {widget dropdown fontsize: 22}
        ///            question q1f widget radio(&quot;joey&quot;,&quot;chandler&quot;)
        ///            question q1g widget dropdown(&quot;ren&quot;,&quot;stimpy&quot;)
        ///        }
        ///    }    
        ///    page page2 
        ///     [rest of string was truncated]&quot;;.
        /// </summary>
        internal static string ExampleStyleSheet {
            get {
                return ResourceManager.GetString("ExampleStyleSheet", resourceCulture);
            }
        }
    }
}
